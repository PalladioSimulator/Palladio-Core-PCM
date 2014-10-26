var App = (function(App) {

	var Options = Backbone.Model.extend({
		urlRoot: 'api/options',

		blacklist: [
			'calibrated'
		],

		defaults: {
			name: 'Default Experiment',
			cpuStrategy: 'fibonacci',
			hddStrategy: 'largeChunks',
			seed: '',
			calibrated: []
		},

		toJSON: function(options) {
			return _.omit(this.attributes, this.blacklist);
		}
	});

	var OptionsView = Backbone.View.extend({
		tagName: 'div',

		events: {
			'click .confirm': 'confirm',
			'change select': 'updateStatus',
			'submit form': 'confirm'
		},
		
		render: function() {
			var template = _.template($('#template-options').html());
			this.$el.append(template(this.model.toJSON()));

			this.$el.find('#cpu-strategy').val(this.model.get('cpuStrategy'));
			this.$el.find('#hdd-strategy').val(this.model.get('hddStrategy'));
			this.$el.find('#seed').val(this.model.get('seed'));

			this.updateStatus();

			return this;
		},

		confirm: function(e) {
			e.preventDefault();
			
			this.$el.find('.confirm').prop('disabled', true);

			var data = {};

			this.$el.find('form').serializeArray().map(function(item) {
				data[item.name] = item.value;
			});

			this.model.set(data);

			this.model.save(null, {
				success: function(model, response) {
					App.updateView();
				}
			});
		},

		updateStatus: function() {
			var cpuStrategy = this.$el.find('select[name="cpuStrategy"]').val();
			var hddStrategy = this.$el.find('select[name="hddStrategy"]').val();
			var seed = this.$el.find('input[name="seed"]').val();

			var cpuId = 'cpu.' + cpuStrategy;
			var hddId = 'hdd.' + hddStrategy;

			var calibrated = this.model.get('calibrated');

			if (_(calibrated).contains(cpuId) && _(calibrated).contains(hddId)) {
				this.$el.find('.warning').hide();
				this.$el.find('.confirm').text('Confirm');
			} else {
				this.$el.find('.warning').show();
				this.$el.find('.confirm').text('Confirm & Calibrate');
			}
		},

		done: function() {
			App.updateView();
		}
	});

	App.OptionsBoxView = Backbone.View.extend({
		tagName: 'div',
		id: 'options',
		className: 'box',

		initialize: function() {
			_.bindAll(this, 'fetchSuccess');

			this.model = new Options;

			this.model.fetch({
				success: this.fetchSuccess
			});
		},

		render: function() {
			var template = _.template($('#template-options-box').html());
			this.$el.append(template());

			return this;
		},

		fetchSuccess: function(model, response, options) {
			this.renderOptions(model);
		},

		renderOptions: function(model) {
			var view = new OptionsView({model: model});
			this.$el.append(view.render().el);
		}
	});

	return App;
})(App || {});
