//
//  PlaySound.swift
//  AdventureTimes
//
//  Created by Aleks on 07/04/2022.
//

import Foundation
import AVFoundation

class AudioPlayer{
    var audioPLayer: AVAudioPlayer?

    init(sound: String, type: String){
        if let path = Bundle.main.path(forResource: sound, ofType: type)
        {
            do{
                
                try AVAudioSession.sharedInstance().setCategory(
                    AVAudioSession.Category.playback
                )
                
                try AVAudioSession.sharedInstance().setActive(true)
                
                audioPLayer = try AVAudioPlayer(contentsOf: URL(fileURLWithPath: path))
            }
            catch{
                print("Could not find sound")
            }
        }
    }
    
     func playSound(){
        audioPLayer?.play()
    }

    func stopPlayingSound(){
        audioPLayer?.stop()
    }

}

