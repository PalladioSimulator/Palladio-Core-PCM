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
			var url = 'ws://' + location.host + location.pathname + 'ws/log';
			console.log(url);

			var connection = new WebSocket(url);
			var self = this;

			connection.onmessage = function(e) {
				var log = $('#log #messages');

				log.append(e.data);

				log.scrollTop(log[0].scrollHeight - log.height());
			}

			connection.onerror = function(e) {
				console.log(e);
			}
		}
	});

	return App;
})(jQuery, App || {});
