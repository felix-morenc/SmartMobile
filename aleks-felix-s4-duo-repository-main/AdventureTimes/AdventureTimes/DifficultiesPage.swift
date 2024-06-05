//
//  DifficultiesPage.swift
//  AdventureTimes
//
//  Created by Felix/Aleks on 06/04/2022.
//

import SwiftUI

struct DifficultiesPage: View {
    
    @State var isBeginner: Bool = false
    @State var isSemi_Pro: Bool = false
    @State var isChallengere: Bool = false

    
    var body: some View {
        ZStack{
            Color.black
            VStack(spacing: 35){
                Text("Beginner")
                    .padding()
                    .frame(width: 220, height: 65, alignment: .center)
                    .foregroundColor(.white)
                    .background(.blue)
                    .font(.system(size: 30))
                    .cornerRadius(45)
                    .onTapGesture{
                        self.isBeginner = true
                    }
                    .sheet(isPresented: $isBeginner, content: {BeginnerPage()})
            
                Text("Semi-Pro")
                    .padding()
                    .frame(width: 220, height: 65, alignment: .center)
                    .foregroundColor(.white)
                    .background(.blue)
                    .font(.system(size: 30))
                    .cornerRadius(45)
                    .onTapGesture{
                        self.isSemi_Pro = true
                    }
                    .sheet(isPresented: $isSemi_Pro, content: {Semi_ProPage()})

                Text("Challenger")
                    .padding()
                    .frame(width: 220, height: 65, alignment: .center)
                    .foregroundColor(.white)
                    .background(.blue)
                    .font(.system(size: 30))
                    .cornerRadius(45)
                    .onTapGesture{
                        self.isChallengere = true
                    }
                    .sheet(isPresented: $isChallengere, content: {ChallengerPage()})
            }
        }
        .ignoresSafeArea()
    }
}

struct DifficultiesPage_Previews: PreviewProvider {
    static var previews: some View {
        DifficultiesPage()
    }
}
