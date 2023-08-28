//
//  AM6ProfileModule.m
//  ReactNativeIOSLibrary
//
//  Created by Spring on 2023/8/28.
//

#import "AM6ProfileModule.h"

@implementation AM6ProfileModule


RCT_EXPORT_MODULE()

#pragma mark
#pragma mark - constantsToExport


- (NSDictionary *)constantsToExport
{
    return @{
             AM6_ACTION:AM6_ACTION,
             AM6_DEVICE:AM6_DEVICE,
             AM6_KEY_MAC:AM6_KEY_MAC,
             AM6_TYPE:AM6_TYPE,
             
             @"ACTION_GET_ALL_CONNECTED_DEVICES":kACTION_GET_ALL_CONNECTED_DEVICES,
            
             };
};


+ (BOOL)requiresMainQueueSetup
{
    return YES;
}


@end
