//
//  ContentView.swift
//  AdventureTimes
//
//  Created by Felix/Aleks on 06/04/2022.
//

import SwiftUI

struct ContentView: View {
    
    @State var isStartAGame: Bool = false
    
    var body: some View {
        ZStack{
            Color.black
                VStack(spacing: 10){
                    Image("logo")                 
                    Text("Start a game")
                        .padding()
                        .frame(width: 220, height: 65, alignment: .center)
                        .foregroundColor(.white)
                        .background(.blue)
                        .font(.system(size: 30))
                        .cornerRadius(45)
                        .onTapGesture{
                            self.isStartAGame = true
                        }
                        .sheet(isPresented: $isStartAGame, content: {DifficultiesPage()})
                    }
                }
        .ignoresSafeArea()
    }
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
