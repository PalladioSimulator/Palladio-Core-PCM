var App = (function(App) {

	App.CalibrationBoxView = Backbone.View.extend({
		tagName: 'div',
		id: 'calibration',
		className: 'box',
		
		initialize: function() {
			this.startSocket();
		},

		render: function() {
			var template = _.template($('#template-calibration-box').html());
			this.$el.append(template());

			return this;
		},

		startSocket: function() {
			var path = location.pathname.replace(/\/$/, '');
			var url = 'ws://' + location.host + path + '/ws/calibration';

			var connection = new WebSocket(url);
			var self = this;

			connection.onmessage = function(e) {
				var data = JSON.parse(e.data);

				self.$el.find('.bar').width(data.progress + '%');
				self.$el.find('.note').text(data.message);

				if (data.progress == 100) {
					setTimeout(function() {
						App.updateView();
					}, 500);
				}
			};

			connection.onopen = function(e) {
				// Send initial data request.
				connection.send('');
			};
			
			connection.onerror = function(e) {
				console.log(e);
			};
		}
	});

	return App;
})(App || {});
