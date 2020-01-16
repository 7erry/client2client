# client2client
Dynamic class loading of two different versions of hazelcast / client2client
<br/>
<br/>Example output for replicating Hazelcast 3.12 cluster to 4.0 cluster
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.client.connection.nio.ClusterConnectorService
<br/>INFO: hz.client_0 [dev] [3.12.5] Trying to connect to cluster with name: dev
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.client.connection.nio.ClusterConnectorService
<br/>INFO: hz.client_0 [dev] [3.12.5] Trying to connect to [127.0.0.1]:5701 as owner member
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.client.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [3.12.5] Setting ClientConnection{alive=true, connectionId=1, channel=NioChannel{/127.0.0.1:58009->/127.0.0.1:5701}, remoteEndpoint=[172.20.4.16]:5701, lastReadTime=2020-01-16 06:30:58.638, lastWriteTime=2020-01-16 06:30:58.611, closedTime=never, connected server version=3.12.5} as owner with principal ClientPrincipal{uuid='da84aad7-025c-4a77-8047-2fddf640d777', ownerUuid='cd7e0929-25ac-4afe-ac09-bfc76a8c1cce'}
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.client.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [3.12.5] Authenticated with server [172.20.4.16]:5701, server version:3.12.5 Local address: /127.0.0.1:58009
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.client.spi.impl.ClientMembershipListener
<br/>INFO: hz.client_0 [dev] [3.12.5] 
<br/>
<br/>Members [2] {
<br/>	Member [172.20.4.16]:5701 - cd7e0929-25ac-4afe-ac09-bfc76a8c1cce
<br/>	Member [172.20.4.16]:5702 - 2e6218d9-342f-4191-9b34-66167dd71cee
<br/>}
<br/>
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.core.LifecycleService
<br/>INFO: hz.client_0 [dev] [3.12.5] HazelcastClient 3.12.5 (20191210 - 294ff46) is CLIENT_CONNECTED
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.internal.diagnostics.Diagnostics
<br/>INFO: hz.client_0 [dev] [3.12.5] Diagnostics disabled. To enable add -Dhazelcast.diagnostics.enabled=true to the JVM arguments.
<br/>Jan 16, 2020 6:30:58 AM com.hazelcast.client.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [3.12.5] Authenticated with server [172.20.4.16]:5702, server version:3.12.5 Local address: /172.20.4.16:58010
<br/>Jan 16, 2020 6:31:01 AM com.hazelcast.internal.config.AbstractConfigLocator
<br/>INFO: Loading 'hazelcast-client-default.xml' from the classpath.
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.spi.ClientInvocationService
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Running with 2 response threads, dynamic=true
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.core.LifecycleService
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] HazelcastClient 4.0-BETA-2 (20191217 - 69e7fda) is STARTING
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.core.LifecycleService
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] HazelcastClient 4.0-BETA-2 (20191217 - 69e7fda) is STARTED
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Trying to connect to cluster with client name: dev
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Trying to connect to [127.0.0.1]:5701
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.nio.ClientConnection
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] ClientConnection{alive=false, connectionId=1, channel=NioChannel{/127.0.0.1:58011->/127.0.0.1:5701}, remoteEndpoint=null, lastReadTime=2020-01-16 06:31:02.337, lastWriteTime=2020-01-16 06:31:02.334, closedTime=2020-01-16 06:31:02.337, connected server version=null} closed. Reason: Connection closed by the other side
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.ClientConnectionManager
<br/>WARNING: hz.client_0 [dev] [4.0-BETA-2] Exception during initial connection to [127.0.0.1]:5701: com.hazelcast.core.HazelcastException: java.io.IOException: Packet not sent to null ClientMessage{connection=null, length=115, correlationId=1, operation=Client.Authentication, messageType=100, isRetryable=true, isEvent=false, isFragmented=false}
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Trying to connect to [127.0.0.1]:5703
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Authenticated with server [172.20.4.16]:5703, server version:4.0-BETA-2 Local address: /127.0.0.1:58012
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.core.LifecycleService
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] HazelcastClient 4.0-BETA-2 (20191217 - 69e7fda) is CLIENT_CONNECTED
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.internal.diagnostics.Diagnostics
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Diagnostics disabled. To enable add -Dhazelcast.diagnostics.enabled=true to the JVM arguments.
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.spi.ClientClusterService
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] 
<br/>
<br/>Members [2] {
<br/>	Member [172.20.4.16]:5703 - 51a271cd-a878-4471-9d07-801d58557be0
<br/>	Member [172.20.4.16]:5704 - 757571a8-a1b8-46ab-86cd-41a11d8520b5
<br/>}
<br/>
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.connection.ClientConnectionManager
<br/>INFO: hz.client_0 [dev] [4.0-BETA-2] Authenticated with server [172.20.4.16]:5704, server version:4.0-BETA-2 Local address: /172.20.4.16:58013
<br/>Jan 16, 2020 6:31:02 AM com.hazelcast.client.impl.statistics.ClientStatisticsService
<br/>INFO: Client statistics is enabled with period 5 seconds.
<br/>10000
<br/>
<br/>

