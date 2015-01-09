curl \
	-H "X-HockeyAppToken: $HOCKEY_APP_TOKEN" \
	-F "ipa=@app/build/outputs/apk/app-debug.apk" \
	https://rink.hockeyapp.net/api/2/apps/upload