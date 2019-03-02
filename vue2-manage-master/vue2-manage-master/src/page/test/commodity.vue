<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-card class="box-card listtable" >
        	
	        <!--商品列表-->
	        <div class="table_container">
	            <el-table :data="tableData" highlight-current-row style="width: 100%">
	            	<!--列表详情-->
					<el-table-column type="expand">
				      	<template slot-scope="props">
					        <el-form label-position="left" inline class="demo-table-expand">
						        <el-form-item label="商品...">
						            <span>{{ props.row.FansCount }}11</span>
						        </el-form-item>
					        </el-form>
				      	</template>
				    </el-table-column>
	                <el-table-column type="index" width="50"></el-table-column>
	                <el-table-column property="commodity" label="商品ID" ></el-table-column>
	            </el-table>
	        </div> 
	        
		</el-card>	
        
    </div>
</template>

<script>
    import headTop from '../../components/headTop'
    import {baseUrl, baseImgPath} from '@/config/env'
    import {getQuerySp} from '@/api/getData'
    export default {
        data(){
            return {
                tableData: [{
                	commodity:'1'
                }],
                offset: 0,
                limit: 20,
            }
        },
    	components: {
    		headTop,
    	},
        created(){
        	
        },
        methods: {
        	handleClose(done){
        		done();
        	},
            //搜索商品
            onSubmit() {
		        alert('submit!');
		    },
            //fetch获取商品信息
            async getcommodity(){
                const Users = await getQuerySp({offset: this.offset, limit: this.limit});
                this.tableData = [];
                Users.forEach(item => {
                    const tableData = {};
					tableData.commodity = item.commodity;					
                    this.tableData.push(tableData);
                })
                console.log("获取商品信息成功")
            }
        }
    }
</script>

<style lang="less" scoped="scoped">
	@import '../../style/mixin';
	.fillcontain{
		.searchusers{
			.el-form-item{
				margin-right: 10px;
				margin-bottom: 5px;
				.el-form-item__label {
				    padding: 11px 4px 11px 0px;
				}
			}
		}
		
	}
	
    
</style>
