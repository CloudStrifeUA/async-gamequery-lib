/***************************************************************************************************
 * MIT License
 *
 * Copyright (c) 2016 Rafael Ibasco
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 **************************************************************************************************/

package com.ribasco.rglib.protocols.valve.source.handlers;

import com.ribasco.rglib.core.handlers.AbstractRequestEncoder;
import com.ribasco.rglib.protocols.valve.source.SourcePacketBuilder;
import com.ribasco.rglib.protocols.valve.source.SourceRequestPacket;
import com.ribasco.rglib.protocols.valve.source.SourceServerRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;

import java.util.List;

/**
 * Created by raffy on 9/17/2016.
 */
@ChannelHandler.Sharable
public class SourceRequestEncoder extends AbstractRequestEncoder<SourceServerRequest> {

    private SourcePacketBuilder builder;

    public SourceRequestEncoder(SourcePacketBuilder builder) {
        this.builder = builder;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, SourceServerRequest request, List<Object> out) throws Exception {
        //Retrieve the request packet from the message
        SourceRequestPacket packet = request.getMessage();
        //Deconstruct the packet
        byte[] deconstructedPacket = builder.deconstruct(packet);

        if (deconstructedPacket != null && deconstructedPacket.length > 0) {
            ByteBuf buffer = ctx.alloc().buffer(deconstructedPacket.length).writeBytes(deconstructedPacket);
            out.add(new DatagramPacket(buffer, request.recipient()));
        }
    }
}