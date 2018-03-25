/*
 *     Copyright 2017 Hewlett-Packard Development Company, L.P.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.hp.octane.integrations.dto.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * PipelineType enum
 */

public enum MultiBranchType {
    NOT_DEFINED("not_defined"),
    MULTI_BRANCH_PARENT("PARENT"),
    MULTI_BRANCH_CHILD("CHILD");


    private String value;

    MultiBranchType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static MultiBranchType fromValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("value MUST NOT be null nor empty");
        }

        MultiBranchType result = NOT_DEFINED;
        for (MultiBranchType v : values()) {
            if (v.value.compareTo(value) == 0) {
                result = v;
                break;
            }
        }
        return result;
    }
}