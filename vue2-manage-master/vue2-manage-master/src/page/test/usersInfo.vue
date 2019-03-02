<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-card class="box-card listtable" >
        	<!--搜索用户-->
        	<div slot="header" class="clearfix">
			   <el-form :inline="true" :model="formInline" class="demo-form-inline">
				  	<el-form-item label="用户名">
				    	<el-input v-model="formInline.username" placeholder="用户名"></el-input>
				  	</el-form-item>
				  	<el-form-item label="性别">
				    	<el-select v-model="formInline.usersex" placeholder="性别">
					      	<el-option label="男" value="男"></el-option>
					      	<el-option label="女" value="女"></el-option>
				    	</el-select>
				  	</el-form-item>
				  	<el-form-item>
				    	<el-button type="primary" @click="onSubmit">查询</el-button>
				  	</el-form-item>
				</el-form>
		  	</div>
		  	<!--添加用户-->
		  	<div slot="header" class="clearfix">
		  		<span>用户列表</span>
			    <el-button type="primary" @click="dialogVisible = true" size="small">添加用户</el-button>
			    <el-dialog title="添加用户" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
				  	<el-form :rules="rules" ref="ruleForm" :model="ruleForm" label-width="80px" class="demo-ruleForm">
						<el-form-item label="用户名" prop="username">
						    <el-input v-model="ruleForm.username"></el-input>
						</el-form-item>
						<el-form-item label="手机号码" prop="phone">
						    <el-input v-model="ruleForm.phone"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')">添加用户</el-button>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</el-form>
				</el-dialog>
		  	</div>
	        <!--用户列表-->
	        <div class="table_container">
	            <el-table :data="tableData" highlight-current-row style="width: 100%">
	            	<!--列表详情-->
					<el-table-column type="expand">
				      	<template slot-scope="props">
					        <el-form label-position="left" inline class="demo-table-expand">
						        <el-form-item label="粉丝数量">
						            <span>{{ props.row.FansCount }}11</span>
						        </el-form-item>
						        <el-form-item label="关注数量">
						            <span>{{ props.row.ConcernCount }}22</span>
						        </el-form-item>
					        </el-form>
				      	</template>
				    </el-table-column>
	                <el-table-column type="index" width="50"></el-table-column>
	                <el-table-column property="" label="头像" width="120"></el-table-column>
	                <el-table-column property="UserId" label="用户名" width="100"></el-table-column>
	                <el-table-column property="" label="性别" width="100"></el-table-column>
	                <el-table-column property="" label="手机号" width="100"></el-table-column>
	                <el-table-column property="" label="爱好" width="100"></el-table-column>
	                <el-table-column property="" label="关注" width="100"></el-table-column>
	                <el-table-column property="" label="粉丝数" width="100"></el-table-column>
                
	                <el-table-column label="操作" >
	                  <template slot-scope="scope">
	                    <el-button
	                      	size="mini"
	                      	@click="handleEdit(scope.$index, scope.row)">编辑</el-button>
	                  </template>
	                </el-table-column>
	            </el-table>
	            
	            <div class="Pagination" style="text-align: left;margin-top: 10px;">
	                <el-pagination
	                  @size-change="handleSizeChange"
	                  @current-change="handleCurrentChange"
	                  :current-page="currentPage"
	                  :page-size="20"
	                  layout="total, prev, pager, next"
	                  :total="count">
	                </el-pagination>
	            </div>
	            
	        </div>    
		</el-card>	
         
        <!--用户信息编辑-->
        <el-dialog title="修改用户信息" v-model="dialogFormVisible">
            <el-form :model="selectTable">
            	<el-form-item label="头像" label-width="100px">
                    <el-upload
                      	class="avatar-uploader"
                      	:action=""
                      	:show-file-list="false"
                      	<img v-if="selectTable.image_path" :src="baseImgPath + selectTable.image_path" class="avatar">
                      	<i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <el-form-item label="用户名" label-width="100px">
                    <el-input v-model="selectTable.username" auto-complete="off"></el-input>
                </el-form-item>
                <!--<el-form-item label="性别" label-width="100px">
                    <el-input v-model="selectTable" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="手机号" label-width="100px">
                    <el-input v-model="selectTable" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="个性签名" label-width="100px">
                    <el-input v-model="selectTable" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="账号注销" label-width="100px">
                    <el-input v-model="selectTable" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="成长等级" label-width="100px">
                    <el-input v-model="selectTable" auto-complete="off"></el-input>
                </el-form-item>-->
            </el-form>
	        <div slot="footer" class="dialog-footer">
	            <el-button @click="dialogFormVisible = false">取 消</el-button>
	            <el-button type="primary" @click="updateShop">确 定</el-button>
	        </div>
        </el-dialog>
        
    </div>
</template>

<script>
    import headTop from '../../components/headTop'
    import {baseUrl, baseImgPath} from '@/config/env'
    import {getUserList,getFansAndConcernCount} from '@/api/getData'
    export default {
        data(){
            return {
            	dialogVisible: false,
            	formInline: {
		          	username: '',
		          	usersex: ''
		        },
		       	ruleForm: {
				 	dialogVisible: false,
		          	username: '',
		          	phone: ''
		       	},
		        rules: {
			        username: [
			            { required: true, message: '请输入用户名', trigger: 'change' }
			        ],
			        phone: [
			            { required: true, message: '请输入手机号码', trigger: 'blur' }
			        ]
				},
                tableData: [{
                	UserId:'1'
                }],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
                currentPage: 1,
                selectTable: {},
                dialogFormVisible: false,
                form: {
		          name: '',
		          region: '',
		          date1: '',
		          date2: '',
		          delivery: false,
		          type: [],
		          resource: '',
		          desc: ''
		        }
            }
        },
    	components: {
    		headTop,
    	},
        created(){
        	this.getUsers();
//          this.initData();
        },
        methods: {
        	handleClose(done){
        		done();
        	},
        	//获取用户数量
//          async initData(){
//              try{
//                  const countData = await getUserCount();
//                  if (countData.status == 1) {
//                      this.count = countData.count;
//                      console.log("获取用户数量成功")
//                  }else{
//                      throw new Error('获取数据数量失败');
//                  }
//                  this.getUsers();
//              }catch(err){
//                  console.log('获取数据数量失败', err);
//              }
//          },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                this.getUsers();
            },
            //添加用户添加按钮
            submitForm(formName) {
		        this.$refs[formName].validate((valid) => {
			        if (valid) {
            			console.log('添加成功!');
			        } else {
			            console.log('添加失败!');
			            return false;
			        }
		        });
		    },
		    //添加用户重置按钮
		    resetForm(formName) {
   	        	this.$refs[formName].resetFields();
	      	},
            //搜索用戶
            onSubmit() {
		        alert('submit!');
		    },
            //fetch获取用户信息
            async getUsers(){
                const Users = await getUserList({offset: this.offset, limit: this.limit});
                this.tableData = [];
                Users.forEach(item => {
                    const tableData = {};
//                  tableData.username = item.username;
//                  tableData.registe_time = item.registe_time;
//                  tableData.city = item.city;
					tableData.UserId = item.UserId;					
                    this.tableData.push(tableData);
                })
                console.log("获取用户信息成功")
            },
              //编辑用户
            handleEdit(index, row) {
                this.selectTable = row;
//              this.address.address = row.address;
                this.dialogFormVisible = true;
//              this.selectedCategory = row.category.split('/');
//              if (!this.categoryOptions.length) {
//                  this.getCategory();
//              }
            },
            //编辑弹窗，
            async updateShop(){
                this.dialogFormVisible = false;
                try{
                    Object.assign(this.selectTable, this.address);
                    this.selectTable.category = this.selectedCategory.join('/');
                    const res = await updateResturant(this.selectTable)
                    if (res.status == 1) {
                        this.$message({
                            type: 'success',
                            message: '更新信息成功'
                        });
                        this.getResturants();
                    }else{
                        this.$message({
                            type: 'error',
                            message: res.message
                        });
                    }
                }catch(err){
                    console.log('更新信息失败', err);
                }
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
