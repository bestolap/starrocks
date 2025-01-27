// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.starrocks.sql.ast;

import com.starrocks.alter.AlterOpType;

import java.util.List;
import java.util.Map;

// reorder column
public class ReorderColumnsClause extends AlterTableColumnClause {
    private final List<String> columnsByPos;

    public List<String> getColumnsByPos() {
        return columnsByPos;
    }

    public ReorderColumnsClause(List<String> cols, String rollup, Map<String, String> properties) {
        super(AlterOpType.SCHEMA_CHANGE, rollup, properties);
        this.columnsByPos = cols;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitReorderColumnsClause(this, context);
    }
}
