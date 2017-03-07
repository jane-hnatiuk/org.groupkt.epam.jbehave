Story:  Search countries

Scenario: Get all countries info
Meta: @id1 scenario1
When user do request for all countries
Then server return response with code 200
And response contains list of all countries

Scenario: Get all Countries info - use Uppercase parameter ALL
Meta: @id2 scenario2
When user do request for all countries using uppercase ALL
Then server return response with code 404


Scenario: Get country info by iso2 code
Meta: @id3 scenario3
Given user has all countries info and pick some 2 character API call
When user do country info request by 2 character API call
Then server return response with code 200
And response contains correct country info

Scenario: Get Country info using not existed iso2code
Meta: @id4 scenario4
When user do country info request using 2 character API call with not existed code
Then server return response with code 200
And response message No Matching Country Found

Scenario: Get country info by iso3 code
Meta: @id5 scenario5
Given user has all countries info and pick some 3 character API call
When user do country info request by 3 character API call
Then server return response with code 200
And response contains correct country info

Scenario: Get country info by iso3 code without specifying code value
Meta: @id6 scenario6
When user do country info request by 3 character API call without code value
Then server return response with code 404

Scenario: Get countries info using search
Meta: @id7 scenario7
When user do search request with search parameter
Then server return response with code 200
And list of search results

Scenario: Get country info using search - without required key
Meta: @id7 scenario7
When user do search request without required text key
Then server return response with code 400
