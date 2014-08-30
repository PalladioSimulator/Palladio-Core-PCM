var App = (function($, App) {

	App.LogBoxView = Backbone.View.extend({
		tagName: 'div',
		id: 'log',
		className: 'box',

		render: function() {
			var template = _.template($('#template-log-box').html());
			this.$el.append(template());

			this.start();

			return this;
		},

		start: function() {
			//var url = 'ws://' + location.host + location.pathname + 'sock/log';
			var url = 'ws://' + location.host + location.pathname + 'ws/log';
			console.log(url);

			var connection = new WebSocket(url);
			var self = this;

			connection.onmessage = function(e) {
				//var data = JSON.parse(e.data);
				//console.log(e);

				var log = $('#log #messages');

				log.append(e.data);
				log.append('\n');

				log.scrollTop(log[0].scrollHeight - log.height());
			}

			connection.onerror = function(e) {
				console.log(e);
			}

			/*
				$.get('${root}', {'action': 'getLog', 'base': logLines}, function(response) {
					var data = response.payload;

					if (data.messageCount > 0) {
						var messages = $('#log #messages');

						for (var i = 0; i < data.messageCount; i++) {
							if (logLines > 0) messages.append('\n');
							logLines++;

							messages.append(data.messages[i]);
						}

						messages.scrollTop(messages[0].scrollHeight - messages.height());
					}
				});
			*/
		}
	});

	return App;
})(jQuery, App || {});
