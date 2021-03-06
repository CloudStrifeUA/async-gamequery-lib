/*
 * MIT License
 *
 * Copyright (c) 2018 Asynchronous Game Query Library
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ibasco.agql.protocols.valve.steam.webapi.interfaces.news;

import com.ibasco.agql.protocols.valve.steam.webapi.SteamApiConstants;
import com.ibasco.agql.protocols.valve.steam.webapi.requests.SteamNewsRequest;

public class GetNewsForApp extends SteamNewsRequest {

    public GetNewsForApp(int apiVersion, int appId) {
        super("GetNewsForApp", apiVersion);
        urlParam(SteamApiConstants.STEAM_URLPARAM_APPID, appId);
    }

    public GetNewsForApp maxLength(int maxLength) {
        urlParam(SteamApiConstants.STEAM_URLPARAM_MAXLENGTH, maxLength);
        return this;
    }

    public GetNewsForApp endDate(int endDate) {
        urlParam(SteamApiConstants.STEAM_URLPARAM_ENDDATE, endDate);
        return this;
    }

    public GetNewsForApp count(int count) {
        urlParam(SteamApiConstants.STEAM_URLPARAM_COUNT, count);
        return this;
    }

    public GetNewsForApp feeds(String feeds) {
        urlParam(SteamApiConstants.STEAM_URLPARAM_FEEDS, feeds);
        return this;
    }
}
