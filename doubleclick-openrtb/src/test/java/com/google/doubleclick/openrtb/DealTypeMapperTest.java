/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doubleclick.openrtb;

import static org.junit.Assert.assertSame;

import com.google.openrtb.OpenRtb.BidRequest.AuctionType;
import com.google.protos.adx.NetworkBid.BidRequest.AdSlot.MatchingAdData.DirectDeal.DealType;

import org.junit.Test;

public class DealTypeMapperTest {
  @Test
  public void testMapper() {
    assertSame(
        AuctionType.FIXED_PRICE,
        DealTypeMapper.toOpenRtb(DealType.PREFERRED_DEAL));
    assertSame(
        DealType.PREFERRED_DEAL,
        DealTypeMapper.toDoubleClick(AuctionType.FIXED_PRICE));

    for (AuctionType openrtb : AuctionType.values()) {
      DealTypeMapper.toDoubleClick(openrtb);
    }
    for (DealType dc : DealType.values()) {
      DealTypeMapper.toOpenRtb(dc);
    }
  }
}
