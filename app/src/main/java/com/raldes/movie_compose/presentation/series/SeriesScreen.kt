package com.raldes.movie_compose.presentation.series

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
fun SeriesScreen(viewModel: SeriesViewModel = hiltViewModel()) {

    val trendingTvSeries = viewModel.trendingTvSeries.value.collectAsLazyPagingItems()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Series") })
    }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(paddingValues)
        ) {
            LazyColumn(Modifier.padding(horizontal = 5.dp)) {
                item(content = {
                    Text(text = "Trending",
                        color = Color.White,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(vertical = 10.dp))
                })

                item(content = {
                    Spacer(modifier = Modifier.height(5.dp))

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                        contentAlignment = Alignment.Center) {
                        
                        LazyRow(content = {
                            items(trendingTvSeries) { series ->
                                //input series item
                                series?.posterUrl?.let {
                                    series.title?.let { it1 ->
                                        SeriesItem(modifier = Modifier.height(220.dp).width(250.dp),
                                            it, it1
                                        )
                                    }
                                }
                            }
                        })

                        trendingTvSeries.apply {
                            when (loadState.refresh) {
                                is LoadState.Loading -> {
                                    CircularProgressIndicator(
                                        modifier = Modifier,
                                        color = Color.White,
                                        strokeWidth = 2.dp
                                    )
                                }

                                is LoadState.Error -> {
                                    //error message here
                                }
                                else -> {}
                            }
                        }
                    }
                })
            }
        }
    }
}