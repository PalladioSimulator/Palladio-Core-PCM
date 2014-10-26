var App = (function($, App) {
	/**
	 * The default escape symbols for Underscore templates conflict with JSP.
	 * Therefore, change them to {{ and }}.
	 */
	_.templateSettings = {
		interpolate: /\{\{(.+?)\}\}/g,
		escape: /\{\{-(.+?)\}\}/g
	};

	App.ControlBoxView = Backbone.View.extend({
		tagName: 'div',
		
		boxes: [
			App.RegistryBoxView,
			App.ModulesBoxView,
			App.ScenariosBoxView,
			App.ResultsBoxView,
			App.LogBoxView
		],

		render: function() {
			_(this.boxes).each(function(box) {
				this.$el.append(new box().render().el);
			}, this);
			
			return this;
		}
	});

	Backbone.View.prototype.close = function() {
		if (typeof this.closing == 'function') {
			this.closing.call(this);
		}

		this.remove();
		this.unbind();
	}

	function showView(view) {
		if (typeof this.currentView != 'undefined') {
			this.currentView.close();
		}

		$('#boxes').html(view.render().el);

		this.currentView = view;
	}

	App.updateView = function() {
		$.get('api/status', function(response) {
			var view;

			switch (response.status) {
				case 'initial':
					view = new App.OptionsBoxView;
					break;

				case 'calibrating':
					view = new App.CalibrationBoxView;
					break;

				case 'started':
					view = new App.ControlBoxView;
					break;

				default:
			}

			showView(view);
		});
	}

	$(document).ready(function() {
		App.updateView();
	});

	return App;
})(jQuery, App || {});
