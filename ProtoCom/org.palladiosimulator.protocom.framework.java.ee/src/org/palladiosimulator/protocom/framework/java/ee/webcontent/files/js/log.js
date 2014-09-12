var App = (function($, App) {

	App.LogBoxView = Backbone.View.extend({
		tagName: 'div',
		id: 'log',
		className: 'box',

		messages: [],
		reuseIndex: 0,
		capacity: 100,

		render: function() {
			var template = _.template($('#template-log-box').html());
			this.$el.append(template());

			this.start();

			return this;
		},

		start: function() {
			var path = location.pathname.replace(/\/$/, '');
			var url = 'ws://' + location.host + path + '/ws/log';

			var connection = new WebSocket(url);
			var self = this;

			connection.onmessage = function(e) {
				var data = JSON.parse(e.data);

				if (_.isArray(data.payload)) {
					_.each(data.payload, function(element) {
						self.append(element)
					});
				} else {
					self.append(data.payload);
				}
			}

			connection.onerror = function(e) {
				console.log(e);
			}
		},

		append: function(message) {
			var log = this.$el.find("#messages");
			var div = this.messages[this.reuseIndex];

			if (typeof div == 'undefined') {
				div = $('<div>').addClass('message');
				this.messages[this.reuseIndex] = div;
			}

			div.text(message);
			div.appendTo(log);

			log.scrollTop(log[0].scrollHeight);

			this.reuseIndex++;

			if (this.reuseIndex >= this.capacity) {
				this.reuseIndex = 0;
			}
		}
	});

	return App;
})(jQuery, App || {});
