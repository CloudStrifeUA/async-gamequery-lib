module agql.steam.master {
    exports com.ibasco.agql.protocols.valve.steam.master;
    exports com.ibasco.agql.protocols.valve.steam.master.client;
    exports com.ibasco.agql.protocols.valve.steam.master.enums;
    requires org.apache.commons.lang3;
    requires agql.lib.core;
    requires io.netty.buffer;
    requires slf4j.api;
    requires io.netty.transport;
    requires io.netty.codec;
}
