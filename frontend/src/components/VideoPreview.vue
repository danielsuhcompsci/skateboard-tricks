<script setup lang="ts">
import { ref } from 'vue'

const files = ref<FileList | null>()
const videoPreviews = ref<string[]>([])
const fileInput = ref<HTMLInputElement>()

function previewVideos(fileList: FileList) {
  // if (!videoPreviews.value) videoPreviews.value = []

  for (const file of fileList) {
    videoPreviews.value.push(URL.createObjectURL(file as Blob))
  }

  console.log(videoPreviews.value)

  // videoPreview.value!.src = URL.createObjectURL(file as Blob)
}

function handleFileInput(event: Event) {
  const target = event.target as HTMLInputElement
  if (target && target.files) {
    files.value = target.files
    previewVideos(files.value)
  }
}

function handleUpload() {
  if (!files.value) {
    console.log('no files to upload')
    return
  }

  for (let i = 0; i < files.value.length; ++i) {
    console.log('uploading...', files.value.item(i)?.name)
  }

  const formData = new FormData()
  for (const file of files.value) {
    formData.append('files', file)
    // file.arrayBuffer().then((buf) => {
    //   console.log('Buf', buf)
    // })
  }

  // formData.append('file', files.value[0])

  // console.log('uploading', files.value[0].name)

  fetch('http://localhost:8080/api/upload', {
    method: 'POST',
    body: formData
  })
    .then((response) => {
      if (response.ok) {
        console.log('Upload successful')
        files.value = null

        //   console.log(fileInput.value?.files)
        fileInput.value!.files = null
        fileInput.value!.value = ''
        videoPreviews.value = []
        //   console.log(fileInput.value?.files)
      } else {
        console.error('Upload failed')
      }
    })
    .catch((error) => {
      console.error('Network error occurred', error)
    })
}
</script>

<template>
  <div class="flex flex-col items-center gap-5">
    <video
      class="rounded-md md:max-w-[600px] max-h-full"
      v-for="videoPreview in videoPreviews"
      v-bind:src="videoPreview"
      v-bind:key="videoPreview"
      controls
      accept="video/*"
      :class="{ hidden: !files }"
    />

    <button
      type="button"
      @click="handleUpload"
      v-if="files"
      class="rounded-2xl bg-green-500 text-white px-3 py-2 max-w-fit"
    >
      Looks good!
    </button>
  </div>

  <input
    ref="fileInput"
    multiple
    type="file"
    accept="video/*"
    @change="handleFileInput"
    :class="{ hidden: files }"
  />
</template>
