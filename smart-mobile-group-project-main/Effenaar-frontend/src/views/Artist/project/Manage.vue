<script setup>
  import TimeSelect from '../../../components/form/TimeSelect.vue';
import PresetCard from '../../../components/cards/artist/PresetCard.vue';
</script>
<template>
  <div class="manage-general">
    <h2>Manage project</h2>
    <TimeSelect/>
  </div>

  <div class="preset-row">
    <header>
      <h3>Lights</h3>
      <div class="btn btn--primary btn--round">add preset</div>
    </header>
    <div class="preset-row-items">
      <PresetCard title="Lime" imgSrc="https://via.placeholder.com/150/49eb34/000000?text=placeholder" id="EJOI2319J"/>
      <PresetCard title="Purple" imgSrc="https://via.placeholder.com/150/c034eb/000000?text=placeholder" id="EJKJ332LI"/>
      <PresetCard title="Pink" imgSrc="https://via.placeholder.com/150/fc3d6d/000000?text=placeholder" id="OTOEI32PJ"/>
      <PresetCard title="Blue" imgSrc="https://via.placeholder.com/150/3344ff/000000?text=placeholder" id="VKV2939LE"/>
    </div>
  </div>
  <div class="preset-row">
    <header>
      <h3>Themes</h3>
      <div class="btn btn--primary btn--round">add preset</div>
    </header>
    <div class="preset-row-items">
      <PresetCard title="Scifi" imgSrc="https://as1.ftcdn.net/v2/jpg/01/71/98/14/1000_F_171981494_N2TgGBGJy0m3NaURXgxQ2H080eUyFnET.jpg" id="POQI2313K"/>
      <PresetCard title="Nightclub" imgSrc="https://i.pinimg.com/originals/19/63/73/19637309fe6560160b655bce4de29424.jpg" id="OEPQ492Jl"/>
      <PresetCard title="Space" imgSrc="https://i.natgeofe.com/k/a2a738a9-e019-4911-98e6-17f31c45ac88/milky-way-2_2x1.jpg" id="VKeiIOwl3"/>
    </div>
  </div>
</template>

<script>
export default {
  components: {
    PresetCard
  },
}
</script>

<style lang="scss" scoped>
  @import './../../../../scss/variables';
  .manage-general {
    background: rgba($dark, 0.1);
    padding: 10px;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    h2 {
      margin-top: 0;
    }
  }

  .preset-row {
    margin: 10px 0 20px;
    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .preset-row-items {
      display: flex;
      flex-wrap: nowrap;
      overflow-x: scroll;
    }
  }
</style>