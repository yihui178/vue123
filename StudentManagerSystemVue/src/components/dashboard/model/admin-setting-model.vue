<template>
  <el-dialog v-dialogDrag title="设置" :visible.sync="dialog" :close-on-click-modal=false append-to-body width="500px">
    <el-form ref="form" :model="form" label-width="80px" :rules="rules">
      <el-form-item label="专业：" prop="profession">
        <el-select v-model="form.professionObj" style="width: 90%" @change="professionChange" value-key="profession">
          <el-option v-for="item in classArr" :key="item.profession" :label="item.profession" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="班级：" prop="grade">
        <el-select v-model="form.grade" style="width: 90%">
          <el-option v-for="item in gradeArr" :key="item" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="课程：" prop="course">
        <el-select v-model="form.course" style="width: 90%">
          <el-option v-for="item in courseArr" :key="item" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button type="primary" @click="click" size="small">确定</el-button>
      <el-button @click="cancel" size="small" >取消</el-button>
    </div>
  </el-dialog>
</template>

<script>
  export default {
    name: "teacher-setting-model",
    data () {
      return {
        dialog: false,
        userInfo: {},
        classArr: [],
        gradeArr: [],
        courseArr: [],
        form: {
          professionObj: {},
          grade: '',
          profession: '',
          course: ''
        },
        rules: {
          grade: [
            { required: true, message: '班级不能为空', trigger: 'change' },
          ],
          profession: [
            {required: true, message: '专业不能为空', trigger: 'change'},
          ],
          course: [
            {required: true, message: '课程不能为空', trigger: 'change'},
          ],
        }
      }
    },
    methods: {
      init () {
        this.dialog = true;
      },
      getProfessionInfo () {
        this.axiosHelper.get(
          '/api/sms/teacher/course/getProfessionInfoByAdmin').then(response => {
          this.classArr = response.data;
          this.form = {
            profession: this.classArr[0].profession,
            grade: this.classArr[0].grade[0],
            professionObj: this.classArr[0],
            course: this.classArr[0].course[0],
          };
          this.gradeArr = this.form.professionObj.grade;
          this.courseArr = this.form.professionObj.course;
          this.postValue();
        }).catch(error => {
          this.$message.error({
            message: '获取专业信息失败'
          }, error)
        });
      },
      professionChange (data) {
        this.form.grade = '';
        this.form.profession = data.profession;
        this.form.course = '';
        this.courseArr = data.course;
        this.gradeArr = data.grade;
      },
      click () {
        this.$refs['form'].validate((valid) => {
          if (valid) {
            this.postValue();
          } else {
            return false;
          }
        })
      },
      postValue () {
        this.$emit('professionInfo', this.form);
        this.dialog = false;
      },
      cancel () {
        this.dialog = false;
      }
    },
    mounted() {
      this.userInfo = JSON.parse(localStorage.userInfo);
      this.getProfessionInfo();
    },
  }
</script>

<style scoped>

</style>
