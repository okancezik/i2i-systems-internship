package hazelcast_oracle.hazelcast_operations;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastOperations {

	public static IMap<Object, Object> getMap() {
		// Hazelcast sunucusunu başlatmak için yapılandırmayı oluşturun
		// Config config = new Config();

		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

		return hazelcastInstance.getMap("my-map");
	}
}
