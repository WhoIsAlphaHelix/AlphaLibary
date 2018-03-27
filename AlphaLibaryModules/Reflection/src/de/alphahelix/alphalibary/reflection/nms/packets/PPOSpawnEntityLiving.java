package de.alphahelix.alphalibary.reflection.nms.packets;

import com.google.common.base.Objects;
import de.alphahelix.alphalibary.core.utils.abstracts.AbstractReflectionUtil;
import de.alphahelix.alphalibary.reflection.ReflectionUtil;


public class PPOSpawnEntityLiving implements IPacket {
	
	private static final AbstractReflectionUtil.SaveConstructor PACKET =
			ReflectionUtil.getDeclaredConstructor("PacketPlayOutSpawnEntityLiving",
					ReflectionUtil.getNmsClass("EntityLiving"));
	
	private Object entity;
	
	public PPOSpawnEntityLiving(Object entity) {
		this.entity = entity;
	}
	
	@Override
	public Object getPacket(boolean stackTrace) {
		return PACKET.newInstance(stackTrace, entity);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getEntity());
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		PPOSpawnEntityLiving that = (PPOSpawnEntityLiving) o;
		return Objects.equal(getEntity(), that.getEntity());
	}
	
	@Override
	public String toString() {
		return "PPOSpawnEntityLiving{" +
				"entity=" + entity +
				'}';
	}
	
	public Object getEntity() {
		return entity;
	}
	
	public PPOSpawnEntityLiving setEntity(Object entity) {
		this.entity = entity;
		return this;
	}
}
