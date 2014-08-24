var App = (function($, App) {

	App.CalibrationBoxView = Backbone.View.extend({
		tagName: 'div',
		id: 'calibration',
		className: 'box',

		render: function() {
			var template = _.template($('#template-calibration-box').html());
			this.$el.append(template());

			this.start();

			return this;
		},

		start: function() {
			var url = 'ws://' + location.host + location.pathname + 'sock/calibration';

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
			}

			connection.onerror = function(e) {
				console.log(e);
			}
		}
	});

	return App;
})(jQuery, App || {});
