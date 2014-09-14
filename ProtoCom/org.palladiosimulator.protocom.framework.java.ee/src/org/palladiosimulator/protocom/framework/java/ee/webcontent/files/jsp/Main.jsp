<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<base href="/org.palladiosimulator.temporary/">
		
		<title>ProtoCom</title>
		
		<script type="text/javascript" src="js/lib/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/lib/jquery.color-2.1.2.min.js"></script>
		<script type="text/javascript" src="js/lib/underscore-1.6.0.min.js"></script>
		<script type="text/javascript" src="js/lib/backbone-1.1.2.min.js"></script>

		<script type="text/javascript" src="js/options.js"></script>

		<script type="text/javascript" src="js/calibration.js"></script>

		<script type="text/javascript" src="js/registry.js"></script>
		<script type="text/javascript" src="js/modules.js"></script>
		<script type="text/javascript" src="js/scenarios.js"></script>
		<script type="text/javascript" src="js/results.js"></script>
		<script type="text/javascript" src="js/log.js"></script>
		<script type="text/javascript" src="js/code.js"></script>

		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
		
		<link rel="icon" href="img/favicon.png">
	</head>
	
	<body>
		<div id="main">
			<div id="header">
				<div id="logo"></div>
				<h1>ProtoCom<span class="subtitle">Performance Prototype</span></h1>
			</div>

			<div id="boxes">
			</div>
		</div>

		<!-- Options -->

		<script type="text/template" id="template-options-box">
			<h2><i class="fa fa-cog fa-fw"></i> Options</h2>
		</script>

		<script type="text/template" id="template-options">
			<form>
				<div class="option">
				<label for="experiment-name">Experiment Name:</label>
				<input id="experiment-name" name="name" value="{{- name }}" autocomplete="off" spellcheck="false">
				</div>

				<div class="option">
				<label for="cpu-strategy">CPU Strategy:</label>

				<select id="cpu-strategy" name="cpuStrategy">
					<option value="primes">Primes</option>
					<option value="count_numbers">Count Numbers</option>
					<option value="fft">FFT</option>
					<option value="fibonacci">Fibonacci</option>
					<option value="mandelbrot">Mandelbrot</option>
					<option value="sortarray">Sort Array</option>
					<option value="void">Void</option>
					<option value="wait">Wait</option>
				</select>
				</div>

				<div class="option">
				<label for="hdd-strategy">HDD Strategy:</label>
				<select id="hdd-strategy" name="hddStrategy">
					<option value="largeChunks">Large Chunks</option>
				</select>
				</div>

				<div class="option">
				<label for="accuracy">Accuracy:</label>
				<select id="accuracy" name="accuracy">
					<option value="low">Low</option>
					<option value="medium">Medium</option>
					<option value="high">High</option>
				</select>
				</div>
			</form>

			<div class="actions">
				<div class="warning">
					<i class="fa fa-exclamation-triangle"></i> The environment is not calibrated for these options.
				</div>

				<button class="confirm">Confirm & Calibrate</button>
			</div>
		</script>

		<!-- Calibration -->

		<script type="text/template" id="template-calibration-box">
			<h2><i class="fa fa-wrench fa-fw"></i> Calibration</h2>

			<div class="progress">
				<div class="bar"></div>
			</div>

			<div class="note">
			</div>
		</script>

		<!-- Registry -->

		<script type="text/template" id="template-registry-box">
			<h2><i class="fa fa-cubes fa-fw"></i> Registry</h2>
		</script>

		<script type="text/template" id="template-registry">
			<form action="#">
				<input class="input" type="text" name="location" value="{{ location }}" autocomplete="off" spellcheck="false">
			</form>
			
			<div class="note">Modules perform registrations and lookups at the specified location during startup.</div>
		</script>

		<!-- Modules -->

		<script type="text/template" id="template-modules-box">
			<h2><i class="fa fa-puzzle-piece fa-fw"></i> Modules</h2>
			
			<table>
				<col class="name-column">
				<col class="state-column">
				<col class="actions-column">

				<thead>
					<tr>
						<th>Name</th>
						<th>State</th>
						<th class="last">Actions</th>
					</tr>
				</thead>

				<tbody>
				</tbody>
			</table>
		</script>

		<script type="text/template" id="template-module">
			<td>{{- name }}</td>
			<td class="state"></td>
			<td class="last">
				<button class="start">Start</button>
			</td>
		</script>

		<!-- Scenarios -->

		<script type="text/template" id="template-scenarios-box">
			<h2><i class="fa fa-user fa-fw"></i> Usage Scenarios</h2>

			<table>
				<col class="name-column">
				<col class="download-column">

				<thead>
					<tr>
						<th>Name</th>
						<th class="last">Download</th>
					</tr>
				</thead>

				<tbody>
				</tbody>
			</table>
		</script>

		<script type="text/template" id="template-scenario">
			<td>{{- name }}</td>
			<td class="last">
				<a href="{{ url }}" download><i class="fa fa-cloud-download fa-fw"></i> JMX</a>
			</td>
		</script>

		<!-- Results -->

		<script type="text/template" id="template-results-box">
			<h2><i class="fa fa-tachometer fa-fw"></i> Analysis Results</h2>

			<table>
				<col class="experiment-column">
				<col class="date-column">
				<col class="download-column">

				<thead>
					<tr>
						<th>Experiment</th>
						<th>Last Change</th>
						<th class="last">Download</th>
					</tr>
				</thead>

				<tbody>
				</tbody>
			</table>
		</script>

		<script type="text/template" id="template-result">
			<td>
				{{- name }}
				<button class="delete">
					<i class="fa fa-times"></i>
				</button>
			</td>
			
			<td>{{- date }}</td>
			
			<td class="last">
				<a href="{{ url }}" download><i class="fa fa-cloud-download fa-fw"></i> ZIP</a>
			</td>
		</script>

		<!-- Log -->

		<script type="text/template" id="template-log-box">
			<h2><i class="fa fa-eye fa-fw"></i> Local Log</h2>

			<div id="messages">
			</div>
		</script>
	</body>
</html>
