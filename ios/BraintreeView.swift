//
//  BraintreeView.swift
//  BraintreeModule
//
//  Created by MOHIT SINGH on 22/01/19.
//  Copyright © 2019 Facebook. All rights reserved.
//
import Foundation
import UIKit
import BraintreeDropIn
import Braintree
@objc(BraintreeView)
class BraintreeView: NSObject {

  
  @objc
  static var result:String!
  @objc
  func showBraintreeDropin(_ clientToken:String, _ callback: @escaping RCTResponseSenderBlock){
    
    //self.fetchClientToken()
    
    self.showDropIn(clientTokenOrTokenizationKey: clientToken,callback:callback)
    
    
  }
  
  func showDropIn(clientTokenOrTokenizationKey: String, callback:@escaping RCTResponseSenderBlock) {
    let request =  BTDropInRequest()
    let dropIn = BTDropInController(authorization: clientTokenOrTokenizationKey, request: request)
    { (controller, result, error) in
      if (error != nil) {
        print("ERROR")
      } else if (result?.isCancelled == true) {
        print("CANCELLED")
      } else if let result = result {
        // Use the BTDropInResult properties to update your UI
        // result.paymentOptionType
        // result.paymentMethod
        // result.paymentIcon
        // result.paymentDescription
        
      let out = result.paymentMethod!
        print("Yes Done\(out.nonce)")
       // BraintreeView.result = out.nonce
        callback([NSNull(), out.nonce])
      }
      controller.dismiss(animated: true, completion: nil)
    }
    UIApplication.shared.keyWindow?.rootViewController?.present(dropIn!, animated: true, completion: nil)
  }
  
  
 /* @objc
  func getResult(_ callback: RCTResponseSenderBlock) {
    
    callback([NSNull(), BraintreeView.result])
    
  }*/
  
  
  @objc
  static func requiresMainQueueSetup() -> Bool {
    
    return true
    
  }
  
}
