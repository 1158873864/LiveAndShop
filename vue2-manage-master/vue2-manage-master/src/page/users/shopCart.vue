<template>
	<div class="aaa">
		<div class="table_container">
            <el-table
                :data="tableData"
                highlight-current-row
                style="width: 100%">
                
                <el-table-column
                  type="index"
                  width="50">
                </el-table-column>
                
                <el-table-column
                  property=" "
                  label="店铺名称"
                  width="100">
                </el-table-column>
                
                <el-table-column
                  property="username"
                  label="产品"
                  width="100">
                </el-table-column>
                
                <el-table-column
                  property=""
                  label="规格"
                  wiwidth="100">
                </el-table-column>
                
                <el-table-column
                  property=""
                  label="价钱"
                  wiwidth="100">
                </el-table-column>
                
                <el-table-column
                  property=""
                  label="数量"
                  width="100">
                </el-table-column>
                
                <!--<el-table-column label="操作" width="200">
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                      size="mini"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                  </template>
                </el-table-column>-->
            </el-table>
        </div>    
	</div>
</template>

<script>
export default {
	data () {
		return {
			
		}
	}
}
</script>

<style lang="less" scoped="scoped">

</style>