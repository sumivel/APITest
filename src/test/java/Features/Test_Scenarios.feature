Feature: BBC Software Engineer in Test Take Home Test
 User should be able to submit GET request to the api
@test1 
Scenario: Verify the response status code and response time 
	Given A rest api
	When  User submits Get request to the api
	Then  The HTTP response status code should be 200
  Then  The HTTP Response time should be below 1000 ms
 @test2
 Scenario: Verify the id field is never null or empty and the segment_type field is always music
	Given A rest api
	When  User submits Get request to the api
	Then  The "id" field in response should be never null or empty
  Then  The "segment_type" field should be "music"
  @test3
  Scenario: Verify the primary field in title_list is never null or empty
	Given A rest api
	When  User submits Get request to the api
	Then  The "primary" field in "title_list" on response should be never null or empty
	@test4
	Scenario: Verify that only one track in the list has offset as true on now_playing field
	Given A rest api
	When  User submits Get request to the api
	Then  The "offset" value in "now_playing" field on response should be true for only one track
  @test5
  Scenario: Verify Date value in response headers
	Given A rest api
	When  User submits Get request to the api
	Then  verify the "Date" value in response header
  