package br.com.jlabs.publish.entity.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateDDLGenerator {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		new HibernateDDLGenerator().execute("org.hibernate.dialect.MySQL5Dialect");
	}

	private void execute(String dialect) throws IOException, ClassNotFoundException {
		Configuration configuration = new Configuration();
		
		// hibernate.hbm2ddl.auto
		configuration.setProperty("hibernate.dialect", dialect);
		
//		addPackage(configuration, "br.com.jlabs.project.entity.enumeration");
		addPackage(configuration, "br.com.jlabs.project.entity");

		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile(String.format("%s_%s.%s ", new Object[] {
				"ddl", dialect, "sql" }));
		boolean consolePrint = true;
		boolean exportInDatabase = false;
		schemaExport.create(consolePrint, exportInDatabase);
	}

	private void addPackage(Configuration configuration, String packageName) throws IOException,
			ClassNotFoundException {
		String[] classNames = getPackageContent(packageName);
		for(String className : classNames) {
			configuration.addAnnotatedClass(Thread.currentThread().getContextClassLoader().loadClass(className));
		}
	}
	
	public static String[] getPackageContent(String packageName) throws IOException{
	    ArrayList<String> list = new ArrayList<String>();
	    Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
	                            .getResources(packageName.replaceAll("\\.", "/"));
	    String className;
	    while (urls.hasMoreElements()) {
	        URL url = urls.nextElement();
	        File dir = new File(url.getFile());
	        for (File f : dir.listFiles()) {
	        	if (f.getName().endsWith("class")) {
					className = f.getName(); 
	        		list.add(packageName + '.' + className.substring(0, className.indexOf('.')));
	        	}
	        }
	    }
	    return list.toArray(new String[]{});
	}
}