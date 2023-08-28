//
//  AM6ProfileModule.h
//  ReactNativeIOSLibrary
//
//  Created by Spring on 2023/8/28.
//

#import <Foundation/Foundation.h>
#if __has_include(<React/RCTAssert.h>)
#import <React/RCTEventDispatcher.h>
#else
#import <React/RCTEventDispatcher.h>
#endif

@interface AM6ProfileModule : NSObject<RCTBridgeModule>

#define AM6_EVENT_NOTIFY @"event_notify_am6"

#define AM6_ACTION @"action"

#define AM6_TYPE @"type"

#define AM6_DEVICE @"devices"

#define AM6_KEY_MAC @"mac"

#define kACTION_GET_ALL_CONNECTED_DEVICES   @"action_get_all_connected_devices"

@end

