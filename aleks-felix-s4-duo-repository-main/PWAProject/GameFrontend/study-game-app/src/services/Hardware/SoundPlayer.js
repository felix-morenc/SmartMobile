import { Howl } from "howler";

class SoundPlayer{
    musicHandler(sound){
        sound.playing() ? sound.pause() :sound.play();
    }

    getSound(audioToPlay){
        return  new Howl({
            src: [audioToPlay]
        });
    
    }
}

export default new SoundPlayer()