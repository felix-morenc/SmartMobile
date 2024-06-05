
<template>
    <div class="create-theme">
        <div class="form-field">
            <label for="username">Name*:</label>
            <input type="text" class="field" id="username" name="username" required/>
        </div>
        <div class="form-field">
            <label for="description">Description*:</label>
            <input type="text" class="field" id="description" name="username" required/>
        </div>
        <div class="form-field form-field--img">
            <input type="file" accept="image/*" @change="fileSelected" class="field"/>
            <img v-if="image" :src="image" width="200px"/>
            <button class="btn btn--dark" @click="upload">Upload</button>
        </div>
        <div class="form-field">
            <div class="btn btn--primary">Save</div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            image: ''
        }
    },
    methods:{
        fileSelected(event){
        const file = event.target.files.item(0);
        const reader = new FileReader();
        reader.addEventListener('load', this.imageLoaded);
        reader.readAsDataURL(file);
        },
        imageLoaded(event){
        this.image = event.target.result;
        },
        upload(){
        
            const form = new FormData();
            form.append(this.file, this.file.name);
            
            axios.post('/upload', form);
        
        }
    }
}
</script>
<style lang="scss" scoped>
    @import './../../../../scss/variables';

    .create-theme {
        padding: 20px;
        display: flex;
        flex-direction: column;
        background: $secondary;
        border-radius: 10px;
    }

    .form-field {
        display: flex;
        flex-direction: column;
        padding: 15px 0;
        label {
            font-weight: 500;
        }
        .field {
            padding: 10px 20px;
        }
        &.form-field--img {
            img {
                width: 100%;
                height: 180px;
                object-fit: cover;
                margin: 5px 0 30px;
            }
        }
    }
</style>