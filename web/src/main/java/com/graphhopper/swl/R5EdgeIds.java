/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.graphhopper.swl;

import com.graphhopper.routing.VirtualEdgeIteratorState;
import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.util.GHUtility;

public class R5EdgeIds {

    static int getR5EdgeId(OriginalDirectionFlagEncoder originalDirectionFlagEncoder, EdgeIteratorState edge) {
        final int ghEdgeKey;
        if (edge instanceof VirtualEdgeIteratorState) {
            ghEdgeKey = GHUtility.getEdgeFromEdgeKey(((VirtualEdgeIteratorState) edge).getOriginalTraversalKey());
        } else {
            ghEdgeKey = edge.getEdge();
        }
        return ghEdgeKey * 2 + (originalDirectionFlagEncoder.isOriginalDirection(edge.getFlags()) ? 0 : 1);
    }

}