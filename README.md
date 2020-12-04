# Snap-API
Android app using Snap Marketing API

APIs to query Snap Project:

1. Login 
    1. GET https://accounts.snapchat.com/login/oauth2/authorize?response_type=code&client_id={client_id}&redirect_uri={redirect_uri}&scope=snapchat-marketing-api&state=wmKkg0TWgppW8PTBZ20sldUmF7hwvU
    2. POST https://accounts.snapchat.com/login/oauth2/access_token
2. Get Your Organization 
    1. GET https://adsapi.snapchat.com/v1/me/organizations
3. Get Ad Accounts
    1. GET https://adsapi.snapchat.com/v1/adaccounts/<ID>
4. Get all campaigns
    1. GET https://adsapi.snapchat.com/v1/adaccounts/{ad_account_id}/campaigns
5. Get All squad Ids under this campaign
    1. GET https://adsapi.snapchat.com/v1/campaigns/{campaign_id}/adsquads
6. Create An Ad
    1. POST https://adsapi.snapchat.com/v1/adsquads/{ad_squad_id}/ads
