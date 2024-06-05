//
//  Semi-ProPage.swift
//  AdventureTimes
//
//  Created by Felix/Aleks on 06/04/2022.
//

import SwiftUI

struct Semi_ProPage: View {
    @State var show = false
    @State var timeRemaining = 15
    @State var timerIsRunning = true
    @State var startedAGame = true
    @State var minutesRemaining = 25
    @State var finishedAGame: Bool = false
    @State private var isLessThanTen = false
    @State private var isLessThanFive = false
    @State private var showMessage = false
    @State private var isTrue = false;
    @State var offsetX : CGFloat = 0
    let timer = Timer.publish(every: 1, on: .main, in: .common).autoconnect()
    private var audioPLayer =  AudioPlayer(sound: "alert",type: "wav")
    
    @StateObject var locationManager = LocationManager()
    @State var locationCalculator = LocationCalculator()
    
            var userLatitude: Double {
            return locationManager.lastLocation?.coordinate.latitude ?? 0
        }

        var userLongitude: Double {
            return locationManager.lastLocation?.coordinate.longitude ?? 0
        }
    
     var isTheLocation: Bool{
        return locationCalculator.checkIfWithinCertainDistance(lan: userLongitude, lat: userLatitude)
    }
    
    var barPosition: Double{
        return locationCalculator.calculateDistanceToLocation(lan: userLongitude , lat: userLatitude)
    }
    
    
    
    var body: some View {
        ZStack{
            
            Color(red: 0.18, green: 0.18
                  , blue:0.18)
            VStack{
                Text("\(minutesRemaining<10 ? "0\(minutesRemaining)" : "\(minutesRemaining)"):\(timeRemaining<10 ? "0\(timeRemaining)" : "\(timeRemaining)")")
                    .padding()
                .foregroundColor(isLessThanTen ? .orange : isLessThanFive ? .red : .green)
                    .font(.system(size: 45))
                    .onReceive(timer){
                        _ in
                        isTrue = isTheLocation
                        offsetX = barPosition
                        if minutesRemaining==0 && timeRemaining==0 { showMessage = true}
                        if showMessage {
                            simpleVibration();                      audioPLayer.stopPlayingSound()}
                        if timerIsRunning{
                            if timeRemaining > 0 {
                                timeRemaining-=1
                                
                                if timeRemaining < 11 && timeRemaining > 6  && minutesRemaining==0{
                                    isLessThanTen = true
                                }
                                else if timeRemaining < 6 && minutesRemaining==0{
                                    audioPLayer.playSound()
                                    isLessThanTen = false
                                    isLessThanFive = true
                                }
                            }
                            else{
                                minutesRemaining-=1
                                timeRemaining+=59
                                isLessThanTen = false
                                isLessThanFive = false
                            }
                    
                        }
                    }
                    .opacity(showMessage ? 0 : 1)
                    .alert("Ran out of time.", isPresented: $showMessage){Button("Ok", role: .cancel){
                        timerIsRunning = false;
                        finishedAGame=true
                    }
                    } message: {Text("You will get them next time champ.")
                        .foregroundColor(.white)
                    }
                HStack(alignment: .center, spacing: -40){
                    RoundedRectangle(cornerRadius: 50)
                        .fill(LinearGradient(gradient: Gradient(colors: [Color(red:0.188,green: 0.215, blue: 0.255), .blue]), startPoint: .trailing, endPoint: .leading))
                        .padding()
                        .frame(width:  175, height: 54)
                    ZStack{
                        Color(.white)
                            .cornerRadius(100)
                            .frame(width: 42, height: 42, alignment: .leading)
                        Image(systemName: "location.circle.fill")                     .font(Font.largeTitle)
                            .foregroundColor(Color(red: 0.32, green: 0.24, blue:0.29))
                    }
                    .offset(x: offsetX - 125)
                    RoundedRectangle(cornerRadius: 50)
                        .fill(LinearGradient(gradient: Gradient(colors: [Color(red:0.255,green: 0.174, blue: 0.174), .red]), startPoint: .leading, endPoint: .trailing))
                        .padding()
                        .frame(width:  175, height: 54)
                        .zIndex(-1)
                }
                Image("tq5")
                Spacer()
            }.alert("Congrats.", isPresented: $isTrue) {Button("Enjoy", role: .destructive){
                isTrue = false;
                finishedAGame=true
            }
            Button("Start a new game", role: .cancel){
                    isTrue = false;
                    finishedAGame=true
                }
        } message: {Text("Congrats, you found the location. Feel free to enjoyt it or start a new game.")
            .foregroundColor(.white)
            .onAppear{
                simpleVibration();
                timerIsRunning = false;
            }
        }
            if !show{
                    Label("Hint", systemImage: "info.circle.fill")
                    .padding()
                    .background(Capsule().stroke())
                    .foregroundColor(.white)
                    .position(x: 180, y: 540)
                    .onTapGesture {
                        withAnimation(.spring()){
                            show.toggle()
                        }
                    }
            }
            else{
                Text("This place houses a Fontys Campus.")
                    .background(RoundedRectangle(cornerRadius: 20).fill(Color(red: 0.22, green: 0.22, blue:0.26)).frame(width:  350, height: 154))
                    .padding()
                    .foregroundColor(.white)
                    .position(x:175,y:280)
                    .frame(width:  350, height: 154)
                    .transition(.move(edge: .bottom))
                    .zIndex(1)
                    .onTapGesture {
                        withAnimation(.easeInOut){
                            show.toggle()
                        }
                    }
            }
            
        }
        .sheet(isPresented: $finishedAGame, content: {ContentView()})
        .alert("Started a game", isPresented: $startedAGame){Button("Ok", role: .cancel){startedAGame = false}
        } message: {Text("You Started a Semi-Pro game . You have 25 minutes to find the place shown on the image. Good luck and have fun. :)")
            .foregroundColor(.white)}
    }
    
    func simpleVibration(){
        let generator = UINotificationFeedbackGenerator()
        generator.notificationOccurred(.error)
    }
}

struct Semi_ProPage_Previews: PreviewProvider {
    static var previews: some View {
        Semi_ProPage()
    }
}
