# Maintenance Monitor Gruppe I

This project aims to build a simple REST API functionality using the Spring Boot Framework.

The API shall deliver the currently stored message to monitors/the customer and be set/reset by the service technicians in case of maintenance.

Sample usage:
```text
1. /api/message                                               -> "Everything works as expected"
2. /api/message/set?m=Service+checks:+No+power+until+5:00+pm  -> "ok"
3. /api/message                                               -> "Service checks: No power until 5:00 pm"
4. /api/message/reset                                         -> "ok"
5. /api/message                                               -> "Everything works as expected"
```