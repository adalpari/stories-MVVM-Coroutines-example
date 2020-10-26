package com.adalpari.storiesexample.usecase

class GetStoriesUseCase: UseCase<GetStoriesUseCase.Input, GetStoriesUseCase.Output> {

    override fun execute(request: Request<Input>, callback: UseCase.Callback<Output>) {
        // This is a mock use case. We just return a static response
    }

    class Input()
    class Output()
}