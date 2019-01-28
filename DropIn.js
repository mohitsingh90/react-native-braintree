"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var react_native_1 = require("react-native");
var DropIn = /** @class */ (function () {
    function DropIn() {
    }
    DropIn.show = function (clientToken) {
        return new Promise(function (resolve, reject) {
            react_native_1.NativeModules.BraintreeView.showBraintreeDropin(clientToken, function (error, result) {
                if (error) {
                    reject(error);
                }
                else {
                    resolve(result);
                }
            });
        });
    };
    return DropIn;
}());
exports.DropIn = DropIn;
