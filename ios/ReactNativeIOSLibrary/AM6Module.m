//
//  AM6Module.m
//  ReactNativeIOSLibrary
//
//  Created by Spring on 2023/8/28.
//

#import "AM6Module.h"

#import "AM6.h"
#import "AM6Controller.h"
#import "AM6ProfileModule.h"

@implementation AM6Module

@synthesize bridge = _bridge;

RCT_EXPORT_MODULE()


#pragma mark
#pragma mark - constantsToExport
- (NSDictionary *)constantsToExport
{
    return @{ @"Event_Notify": AM6_EVENT_NOTIFY };
    
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

#pragma mark
#pragma mark - Init
-(id)init
{
    if (self=[super init])
    {
        
        
    }
    return self;
}

-(AM6*)getAM6WithMac:(NSString*)mac{
    
    AM6Controller *controller = [AM6Controller shareAM6Controller];
    NSArray *amDeviceArray = [controller getAllCurrentAM6Instace];
    
    for(AM6 *tempAM6 in amDeviceArray){
        if([mac isEqualToString:tempAM6.serialNumber]){
            
            return tempAM6;
            break;
        }
    }
    
    return nil;
}

#pragma mark
#pragma mark - Method

RCT_EXPORT_METHOD(getAllConnectedDevices){
    
    
    NSArray*am6array= [[AM6Controller shareAM6Controller] getAllCurrentAM6Instace];
    
    NSMutableArray*deviceMacArray=[NSMutableArray array];
    
    for (int i=0; i<[am6array count]; i++) {
        
        AM6*am6=[am6array objectAtIndex:i];
        
        [deviceMacArray addObject:am6.serialNumber];
        
    }
    
    NSDictionary* deviceInfo = @{AM6_ACTION:kACTION_GET_ALL_CONNECTED_DEVICES,AM6_DEVICE:deviceMacArray};
    
    [self.bridge.eventDispatcher sendDeviceEventWithName:AM6_EVENT_NOTIFY body:deviceInfo];
    
    
}


@end
