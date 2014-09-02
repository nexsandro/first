
		/**
		 * Push html into content or target
		 */
		function pushHtml(htmlData, target, jqXHR) {
			var _target = $('#content');
			if (target)
				_target = target;
			
			if ( "document" == jqXHR.getResponseHeader('target-node')) {
				_target = $(document); 
			}
			
			_target.empty().append(htmlData);
		}

		/**
		 * Do a simple get and put response on content or target using url relative to context.
		 */
		function get(url, target) {
			$.ajax({
				url : url, 
				type : 'GET',
				success  : function (htmlData, textStatus, jqXHR) {
					pushHtml(htmlData, target, jqXHR);
				},
				error : function (error) {
					alert('Error: ' + error);
				},
				dataType : 'html'
			});
			return false;
		}

		/**
		 * Do a simple get and put response on content or target
		 */
		function post(formId, target) {
			var form = $('#' + formId).get(0); // raw html element
			var formData = new FormData(form);    

			$.ajax({
				url: form.action,
				data: formData,
				processData: false,
				contentType: false,
				type: 'POST',
				success: function(htmlData, textStatus, jqXHR){
					pushHtml(htmlData, target, jqXHR);
				}
			});
		}
		
		