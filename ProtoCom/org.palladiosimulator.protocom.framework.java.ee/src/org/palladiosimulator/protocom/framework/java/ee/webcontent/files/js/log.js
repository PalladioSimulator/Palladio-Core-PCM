var App = (function(App) {

	App.LogBoxView = Backbone.View.extend({
		tagName: 'div',
		id: 'log',
		className: 'box',
		
		events: {
			'click .toggle': 'toggle'
		},

		messages: [],
		reuseIndex: 0,
		capacity: 100,
		enabled: true,

		initialize: function() {
			this.startSocket();
		},
		
		render: function() {
			var template = _.template($('#template-log-box').html());
			this.$el.append(template());

			return this;
		},

		startSocket: function() {
			var path = location.pathname.replace(/\/$/, '');
			var url = 'ws://' + location.host + path + '/ws/log';

			this.connection = new WebSocket(url);
			var self = this;

			this.connection.onmessage = function(e) {
				var data = JSON.parse(e.data);

				if (_(data.payload).isArray()) {
					_(data.payload).each(function(element) {
						self.addMessage(element);
					});
				} else {
					self.addMessage(data.payload);
				}
			};

			this.connection.onerror = function(e) {
				console.log(e);
			};
		},

		addMessage: function(message) {
			var log = this.$el.find("#messages");
			var div = this.messages[this.reuseIndex];

			if (typeof div == 'undefined') {
				div = $('<div>').addClass('message');
				this.messages[this.reuseIndex] = div;
			}

			div.text(message.text);
			if (message.error) div.addClass('error');
			
			div.appendTo(log);
			log.scrollTop(log[0].scrollHeight);

			this.reuseIndex++;

			if (this.reuseIndex >= this.capacity) {
				this.reuseIndex = 0;
			}
		},
		
		toggle: function() {
			this.enabled = !this.enabled;
			
			if (this.enabled) {
				this.$el.find('.toggle').css('color', '');
			} else {
				this.$el.find('.toggle').css('color', 'red');
			}
			
			this.connection.send('toggle');
		}
	});

	return App;
})(App || {});
