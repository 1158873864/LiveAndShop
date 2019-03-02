<template>
	<div class="shop-address">
		<head-top></head-top>
		<el-card class="box-card listtable" >
			<div slot="header" class="clearfix">
			    <span>地址列表</span>
			    <el-button type="primary" @click="dialogVisible = true" size="small">添加地址</el-button>
				<el-dialog title="发货地址" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
				  	<el-form :rules="rules" ref="ruleForm" :model="ruleForm" label-width="80px" class="demo-ruleForm">
						<el-form-item label="发货地址" prop="deliveraddress" >
						    <el-select v-model="ruleForm.deliveraddress" placeholder="请选择活动区域">
						      	<el-option label="区域一" value="shanghai"></el-option>
						      	<el-option label="区域二" value="beijing"></el-option>
						    </el-select>
						</el-form-item>
						<el-form-item label="详细地址" prop="detailaddress">
						    <el-input v-model="ruleForm.detailaddress"></el-input>
						</el-form-item>
						<el-form-item label="收件人" prop="user">
						    <el-input v-model="ruleForm.user"></el-input>
						</el-form-item>
						<el-form-item label="收件号码" prop="phone">
						    <el-input v-model="ruleForm.phone"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')" >添加地址</el-button>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</el-form>
				</el-dialog>
		  	</div>
		  	
		  	<div>
				<el-table :data="tableData" style="width: 100%">
			      	<el-table-column prop="date" label="日期" width="180">
			      		
			      	</el-table-column>
				    <el-table-column prop="name" label="姓名" width="180">
				    	
				    </el-table-column>
			      	<el-table-column prop="address" label="地址">
			      		
			      	</el-table-column>
			      	<el-table-column prop="" label="操作">
			      		<el-button size="mini">编辑</el-button>
			      		<el-button size="mini" type="danger">删除</el-button>
			      	</el-table-column>
			    </el-table>
		  	</div>
		</el-card>
	</div>
</template>

<script>
import headTop from '../../components/headTop'

export default{
	data () {
		return{
			dialogVisible: false,
			ruleForm: {
				 	dialogVisible: false,
		          	deliveraddress: '',
		          	detailaddress: '',
		         	user: '',
		          	phone: ''
	       	},
	        rules: {
		        deliveraddress: [
		            { required: true, message: '请选择发货地址', trigger: 'change' },
		        ],
		        detailaddress: [
		            { required: true, message: '请输入详细地址', trigger: 'blur' },
		            { min: 0, message: '详细地址不能为空', trigger: 'blur' }
		        ],
		        user: [
		            { required: true, message: '请输入收件人', trigger: 'blur' },
		        ],
		        phone: [
		            { required: true, message: '请输入收件号码', trigger: 'blur' },
//		            { min: 11, max: 11, message: '长度为 11 个字符', trigger: 'blur' }
		        ]
			},
			tableData: [
				{
		          	date: '2016-05-02',
		          	name: '王小虎',
		          	address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          	date: '2016-05-02',
		          	name: '王小虎',
		          	address: '上海市普陀区金沙江路 1518 弄'
		        },
		        {
		          	date: '2016-05-02',
		          	name: '王小虎',
		          	address: '上海市普陀区金沙江路 1518 弄'
		        }, 
		        {
		          	date: '2016-05-02',
		          	name: '王小虎',
		          	address: '上海市普陀区金沙江路 1518 弄'
		        }
        	]
	    }
	},
	methods: {
		handleClose(done) {
            done();
      	},
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
      	resetForm(formName) {
        	this.$refs[formName].resetFields();
      	}
	},
	components: {
    	headTop
    }
}
</script>

<style lang="less" scoped="scoped">
	.el-card /deep/ .el-card__body {
    	padding: 0px;
	}
</style>