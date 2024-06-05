//
//  LocationCalculator.swift
//  AdventureTimes
//
//  Created by Felix/Aleks on 06/04/2022.
//

import Foundation
import Combine
import CoreLocation
import SwiftUI

class LocationCalculator{
    
    var wantedLocationLon = 5.454075
    var wantedLocationLat =  51.451222
    
    func checkIfAtTheSamePplace(lan: Double, lat: Double) -> Bool{
        if wantedLocationLat == lat && wantedLocationLon == lan { return true}
        
        return false
    }
    
    func checkIfWithinCertainDistance(lan: Double, lat: Double) -> Bool{
        
        let coordinate₀ = CLLocation(latitude: wantedLocationLat, longitude: wantedLocationLon)
        let coordinate₁ = CLLocation(latitude: lat, longitude: lan)

        
//        let coordinate₀ = CLLocation(latitude: 5.0, longitude: 5.0)
//        let coordinate₁ = CLLocation(latitude: 5.0, longitude: 5.0)

        let distanceInMeters = coordinate₀.distance(from: coordinate₁)
        
//        let latDistanceFromWanted : Double = wantedLocationLat * 1000000 - lat * 1000000
//        let lanDistanceFromWanted : Double = wantedLocationLon * 1000000 - lan * 1000000
//
//        let roundedLat = Double(latDistanceFromWanted * 10000).rounded(.toNearestOrEven) / 10000
//        let roundedLan = Double(lanDistanceFromWanted * 10000).rounded(.toNearestOrEven) / 10000
//
//        print(roundedLat)
//        print(roundedLan)

//        if roundedLat < 15 && roundedLan < 15 && roundedLat >= 0 && roundedLan >= 0{ return true }
//        else if roundedLat > -15 && roundedLan > -15 && roundedLat <= 0 && roundedLan <= 0{ return true}
        print(distanceInMeters)
        print(lat, lan)
        
        if distanceInMeters < 15 { return true }
        return false
    }
    
    private func checkDistance(lan: Double, lat: Double) -> Double{
        
        let coordinate₀ = CLLocation(latitude: wantedLocationLat, longitude: wantedLocationLon)
        let coordinate₁ = CLLocation(latitude: lat, longitude: lan)

        let distanceInMeters = coordinate₀.distance(from: coordinate₁)
        
        return distanceInMeters
    }
    
    func calculateDistanceToLocation(lan: Double, lat: Double) -> Double{
        let distanceInMeters = checkDistance(lan: lan, lat: lat)
        var distanceToLocation = 1000 - distanceInMeters
        if distanceToLocation < 0 {distanceToLocation = 0}
        let scaledDistance = distanceToLocation / 4
        return scaledDistance
    }
}

