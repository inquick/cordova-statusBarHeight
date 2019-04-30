var exec = require('cordova/exec');

exports.coolMethod = function (success, error) {
    exec(success, error, 'StatusBarHeight', 'coolMethod',[]);
};