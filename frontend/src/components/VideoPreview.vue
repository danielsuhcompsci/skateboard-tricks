<script setup lang="ts">
import { ref } from 'vue'

const files = ref<FileList | null>()
const videoPreview = ref<HTMLVideoElement>()
const fileInput = ref<HTMLInputElement>()

function previewVideo(file: File) {
  if (!videoPreview.value) return

  videoPreview.value!.src = URL.createObjectURL(file as Blob)
}

function handleFileInput(event: Event) {
  const target = event.target as HTMLInputElement
  if (target && target.files) {
    files.value = target.files
  }
  previewVideo(files.value![0])
}

function handleUpload() {
  if (!files.value) {
    console.log('no files to upload')
    return
  }

  for (let i = 0; i < files.value.length; ++i) {
    console.log('uploading...', files.value.item(i)?.name)
  }

  files.value = null

  //   console.log(fileInput.value?.files)
  fileInput.value!.files = null
  fileInput.value!.value = ''
  //   console.log(fileInput.value?.files)
}
</script>

<template>
  <div class="flex flex-col items-center gap-5">
    <video
      class="rounded-md md:max-w-[60vw]"
      ref="videoPreview"
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
