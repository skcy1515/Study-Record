# api 정의하기 
```
@RestController
public class RestaurantApi {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "This is getRestaurants";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is getRestaurant, " + restaurantId;
    }

    @PostMapping("/restaurant")
    public String createRestaurant() {
        return "This is createRestaurant";
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is editRestaurant, " + restaurantId;
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is deleteRestaurant, " + restaurantId;
    }
}
```
api 패키지에 RestaurantApi 클래스를 생성하고 여러 api 들을 정의해준다.

`@PathVariable` 어노테이션은 URL 경로에서 변수 값을 추출하여 메서드 매개변수로 바인딩한다.

# request 클래스 만들기
```
POST /restaurant
{
  "name": string,
  "address": string,
  "menus": [
    {"name": string, "price": int},
    ...
  ]
}
```
API Spec 대로 CreateAndEditRestaurantRequest 클래스와 CreateAndEditRestaurantRequestMenu 클래스를 정의해준다.

```
@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequest {
    private final String name;
    private final String address;
    private final List<CreateAndEditRestaurantRequestMenu> menus;
}
```
```
@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequestMenu {
    private final String name;
    private final Integer price;
}
```

# api 수정하기
```
    @PostMapping("/restaurant")
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        return "This is createRestaurant, name=" + request.getName() + ", address=" + request.getAddress() +
                ", menu[0].name=" + request.getMenus().get(0).getName() + ", menu[0].price=" + request.getMenus().get(0).getPrice();
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        return "This is editRestaurant, " + restaurantId + ", name=" + request.getName() + ", address=" + request.getAddress();
    }
```
Post, Put 매핑에 RequestBody를 추가해준다.

`@RequestBody` 어노테이션은 요청 본문에서 JSON 데이터를 자바 객체로 변환하여 메서드 매개변수로 바인딩한다.

![image](https://github.com/user-attachments/assets/0cfbe630-7000-4b1f-8eeb-0909e7a9e760)

postman을 통해 JSON 데이터를 보내 객체로 잘 변환됐는지 확인한다.
