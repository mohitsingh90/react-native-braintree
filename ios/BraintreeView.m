#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"


@interface RCT_EXTERN_MODULE(BraintreeView, NSObject)

RCT_EXTERN_METHOD(showBraintreeDropin:(NSString *)clientToken:(RCTResponseSenderBlock)callback)
//RCT_EXTERN_METHOD(getResult: (RCTResponseSenderBlock)callback)

@end
