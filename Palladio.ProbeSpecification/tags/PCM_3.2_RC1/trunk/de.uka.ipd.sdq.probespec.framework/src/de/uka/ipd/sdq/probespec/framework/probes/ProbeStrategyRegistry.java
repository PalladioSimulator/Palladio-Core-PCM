package de.uka.ipd.sdq.probespec.framework.probes;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.exceptions.ProbeStrategyNotFoundException;

/**
 * Basic implementation of the {@link IProbeStrategyRegistry} interface.
 * 
 * @author Philipp Merkle
 *
 */
public class ProbeStrategyRegistry implements IProbeStrategyRegistry {

	private Map<ProbeTypeEntityPair, IProbeStrategy> strategiesMap;

	public ProbeStrategyRegistry() {
		strategiesMap = new HashMap<ProbeTypeEntityPair, IProbeStrategy>();
	}

	@Override
	public IProbeStrategy getProbeStrategy(ProbeType type,
			Object measurableEntity) {
		ProbeTypeEntityPair pair = new ProbeTypeEntityPair(type,
				measurableEntity);
		IProbeStrategy strategy = strategiesMap.get(pair); 
		if (strategy == null)
			throw new ProbeStrategyNotFoundException(
					"Could not find a ProbeStrategy for probe type "
							+ type.name() + " that is able to measure a "
							+ measurableEntity.getClass().getSimpleName());
		return strategy;
	}

	@Override
	public void registerProbeStrategy(IProbeStrategy strategy, ProbeType type,
			Object measurableEntity) {
		ProbeTypeEntityPair pair = new ProbeTypeEntityPair(type,
				measurableEntity);
		strategiesMap.put(pair, strategy);
	}

	private class ProbeTypeEntityPair {

		private ProbeType type;

		private Object entity;

		public ProbeTypeEntityPair(ProbeType type, Object entity) {
			this.type = type;
			this.entity = entity;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((entity == null) ? 0 : entity.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof ProbeTypeEntityPair)) {
				return false;
			}
			ProbeTypeEntityPair other = (ProbeTypeEntityPair) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (entity == null) {
				if (other.entity != null) {
					return false;
				}
			} else if (!entity.equals(other.entity)) {
				return false;
			}
			if (type == null) {
				if (other.type != null) {
					return false;
				}
			} else if (!type.equals(other.type)) {
				return false;
			}
			return true;
		}

		private ProbeStrategyRegistry getOuterType() {
			return ProbeStrategyRegistry.this;
		}

	}

}
