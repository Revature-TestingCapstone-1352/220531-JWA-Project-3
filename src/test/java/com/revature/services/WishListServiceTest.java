package com.revature.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.models.WishList;
import com.revature.repositories.WishListDAO;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {

	
    // Service to test
    @InjectMocks
    private static WishListService wishListService;

    // Mock DAOs
    @Mock
    private static WishListDAO mockWishListDAO;

    @Mock
    private static GameService mockGameService; // Used by getFavGames in WishListService

    // === Testing addFavoriteGame ===

    @Test
    public void afg_invalidUserInputs_nullValues_null() {
        // Input Data
        Game inputGame = null;
        User inputUser = null;

        // Mocking DAO
        when(mockWishListDAO.save(null)).thenReturn(null); // Can't save a wishlist with null values

        // Running test
        WishList actualResult = wishListService.addFavouriteGame(inputGame, inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @ParameterizedTest
    @CsvSource(value = { "-1,1", "1,-1", "-1,-1" })
    public void afg_invalidUserInputs_gameOrUserContainsInvalidValues_null(int gameId, int userId) {
        // Input Data
        Game inputGame = new Game(); // Game with invalid values (i.e. id is null or -1)
        inputGame.setGameID(gameId);
        User inputUser = new User(); // User with invalid values (i.e. id is null or -1)
        inputUser.setId(userId);

        // Mocking DAO
        WishList expectedWishList = new WishList(0, inputUser.getId(), inputGame.getGameID());
        when(mockWishListDAO.save(expectedWishList)).thenReturn(null); // Can't save wishlist with given id of -1

        // Running test
        WishList actualResult = wishListService.addFavouriteGame(inputGame, inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    public void afg_givenGameDoesNotExist_null() {
        // Input Data
        Game inputGame = new Game();
        inputGame.setGameID(1000); // Assuming id of 1000 is not associated with a game
        User inputUser = new User();
        inputUser.setId(1); // Assuming id of 1 exists

        // Mocking DAO
        WishList expectedWishList = new WishList(0, inputUser.getId(), inputGame.getGameID());
        when(mockWishListDAO.save(expectedWishList)).thenReturn(null); // Can't save wishlist with given game id of 1000

        // Running test
        WishList actualResult = wishListService.addFavouriteGame(inputGame, inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    public void afg_givenUserDoesNotExist_null() {
        // Input Data
        Game inputGame = new Game();
        inputGame.setGameID(1); // Assuming id of 1 exists
        User inputUser = new User();
        inputUser.setId(1000); // Assuming id of 1000 is not associated with a user

        // Mocking DAO
        WishList expectedWishList = new WishList(0, inputUser.getId(), inputGame.getGameID());
        when(mockWishListDAO.save(expectedWishList)).thenReturn(null); // Can't save wishlist with given user id of 1000

        // Running test
        WishList actualResult = wishListService.addFavouriteGame(inputGame, inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    public void afg_validUserInput_wishListSaved_savedWishList() {
        // Input Data
        Game inputGame = new Game();
        inputGame.setGameID(1); // Assuming id of 1 exists
        User inputUser = new User();
        inputUser.setId(1); // Assuming id of 1 exists

        // Mocking DAO
        WishList expectedWishList = new WishList(0, inputUser.getId(), inputGame.getGameID());
        when(mockWishListDAO.save(expectedWishList)).thenReturn(expectedWishList); // Found and saved a proper wishlist

        // Running test
        WishList actualResult = wishListService.addFavouriteGame(inputGame, inputUser);

        // Assertions
        assertEquals(expectedWishList, actualResult);
    }

    // === Testing getFavGame ===

    @Test
    public void gfg_invalidUserInput_nullValues_null() {
        // Input Data
        User inputUser = null;

        // Running test
        List<Game> actualResult = wishListService.getFavGames(inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    public void gfg_invalidUserInput_userContainsInvalidValues_null() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(-1);

        // Mocking DAO
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(null); // Can't find list with invalid id

        // Running test
        List<Game> actualResult = wishListService.getFavGames(inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    public void gfg_givenUserDoesNotExist_null() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(1000); // Assuming id of 1000 is not associated with a user

        // Mocking DAO
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(null); // Can't find list of user with id of 1000

        // Running test
        List<Game> actualResult = wishListService.getFavGames(inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    void gfg_gameInWishlistDoesNotExist_null() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(1); // Assuming id of 1 exists

        // Tertiary Data
        int gameId = 1000; // Assuming id of 1000 is not associated with a game

        // Mocking DAO
        List<WishList> expectedWishListList = new ArrayList<WishList>(); // The list of wishlists that the DAO returns
        WishList expectedWishList = new WishList();
        expectedWishList.setGameID(gameId);
        expectedWishListList.add(expectedWishList);
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(expectedWishListList); // Found list of wishlists
        when(mockGameService.getById(gameId)).thenReturn(null); // Can't find game with id of 1000

        // Running test
        List<Game> actualResult = wishListService.getFavGames(inputUser);

        // Assertions
        assertEquals(null, actualResult);
    }

    @Test
    public void gfg_validUserInput_gameListWasRetrieved_listOfGames() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(1); // Assuming id of 1 exists

        // Tertiary Data
        int gameId1 = 1; // Assuming game id of 1 exists
        int gameId2 = 2; // Assuming game id of 2 exists

        // Mocking DAO
        // Mock Data - Wishlist
        List<WishList> expectedWishListList = new ArrayList<WishList>(); // The list of wishlists that the DAO returns
        WishList expectedWishList1 = new WishList();
        WishList expectedWishList2 = new WishList();
        expectedWishList1.setGameID(gameId1);
        expectedWishList2.setGameID(gameId2);
        expectedWishListList.add(expectedWishList1);
        expectedWishListList.add(expectedWishList2);
        // Mock Data - Game
        Game expectedGame1 = new Game();
        Game expectedGame2 = new Game();
        Optional<Game> expectedOptional1 = Optional.of(expectedGame1);
        Optional<Game> expectedOptional2 = Optional.of(expectedGame2);
        expectedGame1.setGameID(gameId1);
        expectedGame2.setGameID(gameId2);
        // Mocking DAO / Service
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(expectedWishListList); // Found list of wishlists
        when(mockGameService.getById(gameId1)).thenReturn(expectedOptional1); // Found the game with id of 1
        when(mockGameService.getById(gameId2)).thenReturn(expectedOptional2); // Found the game with id of 2

        // Running test
        List<Game> actualResult = wishListService.getFavGames(inputUser);
        Object[] expectedResults = { expectedGame1, expectedGame2 };
        Object[] actualResults = { actualResult.get(0), actualResult.get(1) };

        // Assertions
        assertArrayEquals(expectedResults, actualResults);
    }

    // === Testing deleteFavGame ===

    @ParameterizedTest
    @MethodSource("get_dfg_invalidUserInputs")
    public void dfg_invalidUserInput_nullAndNegativeValues_false(User inputUser, int inputGameID) {
        // Running test
        boolean actualResult = wishListService.deleteFavGame(inputUser, inputGameID);

        // Assertions
        assertEquals(false, actualResult);
    }

    private static Stream<Arguments> get_dfg_invalidUserInputs() {
        // Data
        User inputUser = new User();
        inputUser.setId(1); // Assumes user with id of 1 exists
        List<Arguments> arguments = new ArrayList<Arguments>();
        arguments.add(Arguments.of(null, 1));
        arguments.add(Arguments.of(inputUser, -1));
        arguments.add(Arguments.of(null, -1));
        return arguments.stream();
    }

    @Test
    public void dfg_invalidUserInput_userContainsInvalidValues_false() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(-1);
        int inputGameID = 1; // Assumes game with id of 1 exists

        // Mocking DAO
        when(mockWishListDAO.findByUserId(-1)).thenReturn(null); // Can't find wishlist with an invalid id of -1

        // Running test
        boolean actualResult = wishListService.deleteFavGame(inputUser, inputGameID);

        // Assertions
        assertEquals(false, actualResult);
    }

    @Test
    public void dfg_userDoesNotExist_false() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(1000); // Assumes that user id of 1000 does not exist
        int inputGameID = 1; // Assumes game with id of 1 exists

        // Mocking DAO
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(null); // Can't find wishlist with an id of 1000

        // Running test
        boolean actualResult = wishListService.deleteFavGame(inputUser, inputGameID);

        // Assertions
        assertEquals(false, actualResult);
    }

    @Test
    public void dfg_gameDoesNotExist_false() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(1); // Assumes that user id of 1 exists
        int inputGameID = 1000; // Assumes game with id of 1000 does not exist

        // Mocking DAO
        List<WishList> expectedWishListList = new ArrayList<WishList>();
        WishList expectedWishList = new WishList();
        expectedWishList.setGameID(inputGameID);
        expectedWishListList.add(expectedWishList);
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(expectedWishListList); // Found wishlist list associated with user
//        when(mockWishListDAO.delete(expectedWishList)).thenReturn(false); // Not possible -> delete returns nothing (void)

        // Running test
        boolean actualResult = wishListService.deleteFavGame(inputUser, inputGameID);

        // Assertions
        assertEquals(false, actualResult);
    }

    @Test
    public void dfg_validUserInput_wishListWasDeleted_true() {
        // Input Data
        User inputUser = new User();
        inputUser.setId(1); // Assumes that user id of 1 exists
        int inputGameID = 1; // Assumes game with id of 1 exists

        // Mocking DAO
        List<WishList> expectedWishListList = new ArrayList<WishList>();
        WishList expectedWishList = new WishList();
        expectedWishList.setGameID(inputGameID);
        expectedWishListList.add(expectedWishList);
        when(mockWishListDAO.findByUserId(inputUser.getId())).thenReturn(expectedWishListList); // Found wishlist list associated with user
//        when(mockWishListDAO.delete(expectedWishList)).thenReturn(true); // Not possible -> delete returns nothing (void)

        // Running test
        boolean actualResult = wishListService.deleteFavGame(inputUser, inputGameID);

        // Assertions
        assertEquals(true, actualResult);
    }

}
