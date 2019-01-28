import {NativeModules} from "react-native";

export class DropIn {

    static show(clientToken: string): Promise<string> {
        return new Promise<string>((resolve, reject) => {
            NativeModules.BraintreeView.showBraintreeDropin(clientToken, (error, result) => {
                if (error) {
                    reject(error);
                } else {
                    resolve(result);
                }
            })
        })
    }

}